package com.cares.baseframe.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cares.baseframe.bean.DeptAgentVo;
import com.cares.baseframe.bean.Organization;
import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.bean.Tree;
import com.cares.baseframe.mapper.CarrierMapper;
import com.cares.baseframe.mapper.DeptAgentMapper;
import com.cares.baseframe.mapper.OrganizationMapper;
import com.cares.baseframe.model.Carrier;
import com.cares.baseframe.service.OrganizationService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;
    
    @Autowired
    private CarrierMapper carrierMapper;
    
    @Autowired
    private DeptAgentMapper deptAgentMapper;

    @Override
    public List<Tree> findTree(Map<String, String> paraMap) {
        List<Tree> trees = Lists.newArrayList();

        List<Organization> organizationFather = null;
        if (paraMap == null) {
        	organizationFather = organizationMapper.findOrganizationAllByPidNull();
		}else {
			organizationFather = organizationMapper.findOrganizationAllByAptCd(paraMap);
		}
        

        if (organizationFather != null) {
            for (Organization organizationOne : organizationFather) {
                Tree treeOne = new Tree();

                treeOne.setId(organizationOne.getDeptId());
                treeOne.setText(organizationOne.getDeptName());
                treeOne.setIconCls(organizationOne.getDeptIcon());

                List<Organization> organizationSon = organizationMapper.findOrganizationAllByPid(organizationOne.getDeptId());

                if (organizationSon != null) {
                    List<Tree> tree = Lists.newArrayList();
                    for (Organization organizationTwo : organizationSon) {
                        Tree treeTwo = new Tree();
                        treeTwo.setId(organizationTwo.getDeptId());
                        treeTwo.setText(organizationTwo.getDeptName());
                        treeTwo.setIconCls(organizationTwo.getDeptIcon());
                        
                        List<Organization> organizationSons = organizationMapper.findOrganizationAllByPid(organizationTwo.getDeptId());

                        if (organizationSons != null) {
                        	 List<Tree> treeS = Lists.newArrayList();
                        	 for (Organization organizationThree : organizationSons) {
                        		 Tree treeThree = new Tree();
                        		 treeThree.setId(organizationThree.getDeptId());
                        		 treeThree.setText(organizationThree.getDeptName());
                        		 treeThree.setIconCls(organizationThree.getDeptIcon());
                        		 
                        		 List<Organization> organizationSont = organizationMapper.findOrganizationAllByPid(organizationThree.getDeptId());
                        		 if (organizationSont != null) {
                                 	List<Tree> treeT = Lists.newArrayList();
                                 	for (Organization organizationFour : organizationSont) {
                                 		Tree treeFour = new Tree();
                                 		treeFour.setId(organizationFour.getDeptId());
                                 		treeFour.setText(organizationFour.getDeptName());
                                 		treeFour.setIconCls(organizationFour.getDeptIcon());
                                 		
                                 		treeT.add(treeFour); //四级结构
                                 	}
                                 	treeThree.setChildren(treeT);
                        		 }else {
                        			 treeThree.setState("closed");
								 }
                        		 treeS.add(treeThree);   //三级
                        	 }
                        	 treeTwo.setChildren(treeS);
						}else {
							 treeTwo.setState("closed");
						}
                        tree.add(treeTwo); //二级
                    }
                    treeOne.setChildren(tree);
                } else {
                    treeOne.setState("closed");
                }
                trees.add(treeOne);
            }
        }
        return trees;
    }

    @Override
    public List<Organization> findTreeGrid(Map<String, Object> paraMap) {
        return organizationMapper.findOrganizationAll(paraMap);
    }

    @Override
    public Long addOrganization(Organization organization) {
        return organizationMapper.insert(organization);
    }

    @Override
    public Organization findOrganizationById(Long id) {
        return organizationMapper.findOrganizationById(id);
    }

    @Override
    public void updateOrganization(Organization organization) {
        organizationMapper.updateOrganization(organization);
    }

    @Override
    public void deleteOrganizationById(Long id) {
        organizationMapper.deleteOrganizationById(id);
    }

	@Override
	public void queryOrganizationByPage(PageInfo pageInfo) {
		List<Organization> rows = organizationMapper.findOriganzationByPage(pageInfo);
		StringBuilder agentInfo=new StringBuilder();
		for (Organization organization : rows) {
			Map<String,Object> paramMap=Maps.newHashMap();
			paramMap.put("deptId", organization.getDeptId());
			List<DeptAgentVo> agnet = deptAgentMapper.fingDeptAgentVoByParam(paramMap);
			for (int i=0;i<(agnet.size()>3?3:agnet.size());i++) {
				if(i>0&&i<=agnet.size()-1){
					agentInfo.append(";");
				}
				agentInfo.append(agnet.get(i).getAptCd());
				agentInfo.append(":");
				String carrier=agnet.get(i).getCarrier();
				if(agnet.get(i).getCarrier().length()>29){
					carrier=StringUtils.substring(agnet.get(i).getCarrier(), 0, 29);
				}
				agentInfo.append(carrier);
			}
			organization.setAgentInfo(agentInfo.toString());
			agentInfo.setLength(0);
		}
		pageInfo.setRows(rows);
		pageInfo.setTotal(organizationMapper.findOriganzationByPageCount(pageInfo));
	}

	@Override
	public List<String> queryAllCarrier() {
		return carrierMapper.findAllCarrier();
	}

	@Override
	public int countCarrierByParam(Carrier carrier) {
		return carrierMapper.countCarrierByParam(carrier);
	}
	public static void main(String[] args) {
		String s="FF,MU,AV,AB,TH,KM,FF,MU,AV,AB,TH,KM,FF,MU,AV,AB,TH,KM,FF,MU,AV,AB,TH,KM";
		System.out.println(StringUtils.substring(s, 0, 29));
	}
}

//-------------------------------------------------------开发模式  fis3 release -wL
fis.match('*', {
    deploy: fis.plugin('local-deliver', {
        to: 'E:/devTools/apache-tomcat-7.0.42/webapps'
    }),
    release: '/jc_web/$0'
});

fis.match('*.{js,css,png}', {
    useHash: false,
    useSprite: false,
    optimizer: null
});

// cmd手动删除文件夹命令：(/s删除子目录  /q无提示)
// rd /s /q D:\devSoftware\apache-tomcat-7.0.42\webapps\jc_web
//-------------------------------------------------------发布模式  fis3 release prod
fis.media('prod').match('*', {
    deploy: fis.plugin('local-deliver', {
        // to: 'D:/devSoftware/apache-tomcat-7.0.42/webapps'
        to: '../jc_web_prod'
    })
});

fis.media('prod').match('*', {
    release: '/jc_web/$0'
});

fis.media('prod').match('*.{js,css,png}', {
    useHash: true // 加 md5
});

// 启用 fis-spriter-csssprites 插件
fis.media('prod').match('::package', {
    spriter: fis.plugin('csssprites')
});

fis.media('prod').match('*.js', {
    // fis-optimizer-uglify-js 插件进行压缩，已内置
    optimizer: fis.plugin('uglify-js')
});

fis.media('prod').match('*.css', {
    // fis-optimizer-clean-css 插件进行压缩，已内置
    optimizer: fis.plugin('clean-css'),
    useSprite: true
});

fis.media('prod').match('*.png', {
    // fis-optimizer-png-compressor 插件进行压缩，已内置
    optimizer: fis.plugin('png-compressor')
});

fis.media('prod').match('*.min.{js,css}', {
    useHash: false,
    useSprite: false,
    optimizer: null
});

fis.media('prod').match('*_module.png', {
    useHash: false
});


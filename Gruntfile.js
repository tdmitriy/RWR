module.exports = function (grunt) {

    var libsSrcPath = 'src/main/webapp/libs';
    var buildJsLibsName = 'libs.js', buildJsMinLibsName = 'libs.min.js';

    var jsAppSrcPath = 'src/main/webapp/angular';
    var buildJsAppName = 'angular-rwr-app.js', buildJsMinAppName = 'angular-rwr-app.min.js';

    var libsJsFiles =
        [libsSrcPath + '/jquery.min.js',
            libsSrcPath + '/bootstrap.min.js',
            libsSrcPath + '/angular.min.js',
            libsSrcPath + '/dependencies/*.js'];

    var cssFiles = [libsSrcPath + '/css/*.css', 'src/main/webapp/css/*.css'];
    var buildCssName = 'styles.css', buildCssMinName = 'styles.min.css';

    var rwrAppFiles =
        [jsAppSrcPath + '/rwr-app.js',
            jsAppSrcPath + '/controller/*.js',
            jsAppSrcPath + '/service/*.js',
            jsAppSrcPath + '/filter/*.js',
            jsAppSrcPath + '/factory/*.js'];

    var buildDstPath = 'src/main/webapp/build';

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),

        concat: {
            main: {
                options: {
                    separator: ';\n'
                },
                files: [
                    //js lib files
                    {
                        src: libsJsFiles,
                        dest: buildDstPath + '/js/' + buildJsLibsName
                    },
                    //js rwr-app files
                    {
                        src: rwrAppFiles,
                        dest: buildDstPath + '/js/' + buildJsAppName
                    }
                ]
            }
        },
        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy") %> */\n',
                mangle: {
                    except: ['jquery.min.js', 'bootstrap.min.js', 'angular.min.js']
                },
                compress: {
                    sequences: true,
                    dead_code: true,
                    conditionals: true,
                    booleans: true,
                    unused: true,
                    if_return: true,
                    join_vars: true,
                    drop_console: true
                }
            },
            main: {
                files: [
                    //js lib files
                    {
                        src: buildDstPath + '/js/' + buildJsLibsName,
                        dest: buildDstPath + '/js/' + buildJsMinLibsName
                    },
                    //js rwr-app files
                    {
                        src: buildDstPath + '/js/' + buildJsAppName,
                        dest: buildDstPath + '/js/' + buildJsMinAppName
                    }
                ]
            }
        },

        cssmin: {
            options: {
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy") %> */\n'
            },
            concat_css: {
                files: [
                    {
                        src: cssFiles,
                        dest: buildDstPath + '/css/' + buildCssName
                    }
                ]
            },
            minify_css: {
                files: [
                    {
                        src: buildDstPath + '/css/' + buildCssName,
                        dest: buildDstPath + '/css/' + buildCssMinName
                    }
                ]
            }
        },
        //copy bootstrap and font-awesome fonts from lib to build dir
        copy: {
            main: {
                files: [
                    {expand: true, cwd: libsSrcPath + '/fonts', src: '**', dest: buildDstPath + '/fonts/'}
                ]
            }
        },
        watch: {
            scripts: {
                files: [libsJsFiles, rwrAppFiles, cssFiles],
                tasks: ['concat'],
                options: {
                    spawn: false
                }
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-watch');

    grunt.registerTask('default', ['concat', 'cssmin:concat_css', 'cssmin:minify_css', 'uglify', 'copy']);
};
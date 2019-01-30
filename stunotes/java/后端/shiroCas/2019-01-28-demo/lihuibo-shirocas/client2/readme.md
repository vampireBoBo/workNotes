注意！！!
1、client2的项目是通过simple maven项目后期转变成web项目  故在动态发布时 需要添加maven的依赖库 否则部署时 项目不会是一个web项目，即没有spring-web的jar
2、动态添加的maven依赖 若对项目进行maven update后，该依赖需要再次手动添加


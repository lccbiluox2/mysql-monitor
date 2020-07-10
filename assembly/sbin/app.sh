#!/usr/bin/env bash

# 启动/调试/停止/重启
action=$1
# 启动环境,不同环境对应不同jvm参数;如果action为debug,则表示远程调试端口号
environment=$2

# 版本号
version="0.0.1-SNAPSHOT"
# 配置文件绝对路径
conf_path="/opt/conf/spring-blog/application.properties"

# 默认jvm参数
jvm_xms="256m"
jvm_xmx="256m"
# 远程调试默认端口号
debug_port=7780

# app相关信息
appName="spring-blog-provider"
runJar="spring-blog-provider-"${version}".jar"
mainClass="com.neo.BlogApplication"

# 当前文件所在目录绝对路径
SHELL_FOLDER=$(cd "$(dirname "$0")";pwd)
# jar文件所在目录绝对路径
JAR_FOLDER="${SHELL_FOLDER}/../jars"
# jar文件绝对路径
JAR_PATH="${JAR_FOLDER}/${runJar}"

# 设置jvm参数
set_jvm(){
    if [ "${environment}" = "test" ];then
        jvm_xms="256m";
        jvm_xmx="256m";
    elif [ "${environment}" = "prd" ];then
        jvm_xms="1024m";
        jvm_xmx="1024m";
    elif [ "${environment}" = "saas" ];then
        jvm_xms="1024m";
        jvm_xmx="1024m";
    elif [ "${environment}" = "private" ];then
        jvm_xms="512m";
        jvm_xmx="512m";
    else
        echo -e "使用默认jvm配置..."
    fi

    if [ "${action}" = "debug" -a "${environment}xx" != "xx" ];then
        case "${environment}" in
            [1-9][0-9]*)
                debug_port=${environment}
                ;;
            *)
                ;;
        esac
        echo -e "远程调试端口号: "${debug_port}
    fi

    # 启动命令
    start_cmd="java -Djava.security.egd=file:/dev/./urandom -Xms${jvm_xms} -Xmx${jvm_xmx} \
        -jar ${JAR_PATH} ${mainClass} --spring.config.location=${conf_path}"
    # 调试命令
    debug_cmd="java -Djava.security.egd=file:/dev/./urandom -Xms${jvm_xms} -Xmx${jvm_xmx} \
        -Xdebug -Xrunjdwp:transport=dt_socket,suspend=n,server=y,address=${debug_port} \
        -jar ${JAR_PATH} ${mainClass} --spring.config.location=${conf_path}"
}

# 启动
start(){
    echo -e "正在启动...";
    echo -e ${start_cmd}
    nohup ${start_cmd} > /dev/null 2>&1 &
    echo -e "启动完成."
}

# 远程调试
debug(){
    echo -e "正在启动调试模式...";
    echo -e ${debug_cmd}
    nohup ${debug_cmd} > /dev/null 2>&1 &
    echo -e "启动完成, 远程调试端口:${debug_port}."
}

# 停止
stop(){
    echo -e "正在停止服务..."
    jps| awk '{if($2==runJar) print $1}' runJar=${runJar} >child.txt
    cat child.txt
    cat child.txt | while read line
    do
        kill ${line}
    done
    rm -rf child.txt
    echo -e "停止完成."
}

# 重启
restart(){
    stop;
    sleep 3;
    start;
}

# 判断是否是root账户启动进程
if_use_root(){

    user=`whoami`

    if [ ${user} = "root" ];then
        read -p "不建议使用 "${user}" 账户启动服务, 确定要启动吗? (yes or no): " use_root

        case "${use_root}" in
            y)
                echo "正在使用 "${user}" 账户启动服务."
                ;;
            yes)
                echo "正在使用 "${user}" 账户启动服务."
                ;;
            n)
                echo "退出,请切换到其他用户启动服务."
                exit 1
                ;;
            no)
                echo "退出,请切换到其他用户启动服务."
                exit 1
                ;;
            *)
                echo "yes or no"
                if_use_root
                ;;
        esac
    fi

}


if [ ! -f ${JAR_PATH} ];then
    echo -e "${JAR_PATH} 不存在, 请检查启动脚本中的版本配置或检查文件是否存在.";
    exit 1
fi

if [ ! -f ${conf_path} ];then
    echo -e "${conf_path} 不存在, 请检查启动脚本中的配置文件路径是否正确或检查文件是否存在.";
    exit 1
fi


if [ $# -lt 1 -o $# -gt 2 ];then
    echo -e "运行命令: \n\t$0 start\n\t$0 stop\n\t$0 debug\n\t$0 restart";
    echo -e "\t$0 start test\n\t$0 start prd\n\t$0 start saas\n\t$0 start private\n\t$0 debug port";
    exit 1;
fi

if [ "${action}" = "start" ];then
    if_use_root;
    set_jvm;
    start;
elif [ "${action}" = "stop" ];then
    stop;
elif [ "${action}" = "restart" ];then
    if_use_root;
    set_jvm;
    restart;
elif [ "${action}" = "debug" ];then
    if_use_root;
    set_jvm;
    debug;
else
    echo -e "不支持 ${action}, 只支持 [start, stop, debug, restart]"
    exit 1;
fi

sleep 2;

jps -mlv |grep ${runJar}
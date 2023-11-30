# Goff专版镜像
# desc：https://console.cloud.tencent.com/tke2/registry/qcloud/default/detail/info?rid=1&reponame=goff/jdk8
FROM ccr.ccs.tencentyun.com/goff/arm-jdk8

MAINTAINER admin

ENV jar docker_run.jar
WORKDIR /app/

# 命名jar包
ADD target/*.jar /app/${jar}
# 下载相关工具，可以按需添加
# RUN wget -P /usr/local/ http://abc.com

# 请在镜像运行环境定义JVM内存参数JAVA_OPTS，否则默认内存512m
# ex：export JAVA_OPTS='-Xms512m -Xmx512m -XX:NewRatio=1 -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=256m'
CMD sh -c ' if [ "$JAVA_OPTS" = "" ];  then export JAVA_OPTS="-Xms512m -Xmx512m -XX:NewRatio=1 -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=256m" ; else echo JAVA_OPTS is ${JAVA_OPTS} ; fi  \
     && exec java ${JAVA_OPTS} -Xloggc:/data/tsf_apm/monitor/jvm-metrics/gclog.log -XX:+PrintGCDateStamps -XX:+PrintGCDetails -verbose:gc -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=8 -XX:GCLogFileSize=50M   -XX:+AlwaysPreTouch -Xss512k -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=75 -XX:+UseCMSInitiatingOccupancyOnly -XX:+ExplicitGCInvokesConcurrent -XX:+ParallelRefProcEnabled -XX:+CMSParallelInitialMarkEnabled -XX:MaxTenuringThreshold=3 -XX:+UnlockDiagnosticVMOptions -XX:ParGCCardsPerStrideChunk=1024 -XX:-UseBiasedLocking -XX:AutoBoxCacheMax=20000 -Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true -Dfile.encoding=UTF-8 -javaagent:/usr/local/TencentCloudJvmMonitor-1.1.0-RELEASE.jar=hascontroller=true -jar ${jar} '

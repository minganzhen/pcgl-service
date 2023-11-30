#!/bin/bash
proc_id=`ps -ef |grep -w SkzsServiceWebApplication | grep -v grep | awk '{print $2}'`
proc_msg=`ps -ef |grep -w SkzsServiceWebApplication | grep -v grep | awk '{print $8,$9,$10,$11,$12,$13}'`
ps -ef |grep -w SkzsServiceWebApplication | grep -v grep | awk '{print $2}' |xargs kill -9
echo "kill ${proc_id} ${proc_msg}"
sh ./startup.sh > /dev/null 2>&1
echo "server started !"

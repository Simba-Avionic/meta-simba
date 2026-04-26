#!/bin/bash

out_put_file="/srp/token/token.hex"
out_put_file_ver="/srp/token/token.hex.sha1"

if [ ! -d "/srp/update" ]; then
        cd /srp
        mkdir update
        echo "[SRP-PLATFORM]: [INFO] SRP sw dir  added"
fi

if [ ! -d "/srp/update/backup" ]; then
        cd /srp/update
        mkdir backup
        echo "[SRP-PLATFORM]: [INFO] Backup dir added"
fi

if [ ! -d "/srp/update/new" ]; then
        cd /srp/update
        mkdir new
        echo "[SRP-PLATFORM]: [INFO] New dir added"
fi

if [ ! -d "/srp/update/current" ]; then
        cd /srp/update
        mkdir current
        echo "[SRP-PLATFORM]: [INFO] Current dir added"
fi

if sha1sum -c $out_put_file_ver;
then
sh /srp/opt/cpu_srp/start_up.sh
else
echo "[SRP-PLATFORM]: [ERROR] Security file breach detected"
echo "[SRP-PLATFORM]: [INFO] Deletion of invalid token"
rm $out_put_file
rm $out_put_file_ver
echo "[SRP-PLATFORM]: [INFO] Reboot the system"
fi
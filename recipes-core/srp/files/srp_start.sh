#!/bin/bash

out_put_file="/srp/token/token.hex"
out_put_file_ver="/srp/token/token.hex.sha1"

if [ ! -d "/srp/update" ]; then
        cd /srp
        mkdir update
        echo "SRP sw dir  added"
fi

if [ ! -d "/srp/update/backup" ]; then
        cd /srp/update
        mkdir backup
        echo "Backup dir added"
fi

if [ ! -d "/srp/update/new" ]; then
        cd /srp/update
        mkdir new
        echo "New dir added"
fi

if [ ! -d "/srp/update/current" ]; then
        cd /srp/update
        mkdir current
        echo "Current dir added"
fi

if [ ! -e "/srp/token/token.hex" ]
then
        if [ ! -d "/srp/token" ]; then
                cd /srp
                mkdir token
        fi
        var1="$(cat /sys/class/net/*/address | tr -d '\n')"
        sec='sec_token2'
        eng='eng_token2'
        upload='upload_token2'
        sec=$var1$sec
        sec="$(echo $sec | sha256sum)"
        eng=$var1$eng
        eng="$(echo $eng | sha256sum)"
        upload=$var1$upload
        upload="$(echo $upload | sha256sum)"
        echo ${sec::-3} > $out_put_file
        echo ${eng::-3} >> $out_put_file
        echo ${upload::-3} >> $out_put_file
        ver_hash="$(sha1sum $out_put_file)"
        echo $ver_hash > $out_put_file_ver
        chmod -w $out_put_file
        chmod -w $out_put_file_ver
fi

if sha1sum -c $out_put_file_ver;
then
sh /srp/opt/cpu_simba/start_up.sh
else
echo "[SRP]: [ERROR] Wykryto naruszenie plikow bezpieczenstwa"
fi
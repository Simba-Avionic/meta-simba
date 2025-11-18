#!/bin/bash

if [ ! -d "/srp/update/" ]; then
        mkdir -p /srp/update/
        echo "SRP sw dir  added"
fi

if [ ! -d "/srp/update/backup" ]; then
        mkdir -p /srp/update/backup
        echo "Backup dir added"
fi

if [ ! -d "/srp/update/new" ]; then
        mkdir -p /srp/update/new
        echo "New dir added"
fi

if [ ! -d "/srp/update/current" ]; then
        mkdir -p /srp/update/current
        echo "Current dir added"
fi

# if [ "$(ls -A /etc/simba/new | grep .tar)" ]; then
#     echo "SRP update detected:"
#     ls -A /etc/simba/new

#     if [ ! -d "/srp/opt/cpu_srp/update.sh" ]; then
#         echo "Update script not detected !!!"
#         for file in /etc/simba/new/*.tar; do
#             echo "Opening: $file"
#             cp $file /etc/simba/current
#             tar -xvf $file
#             mv -fv opt /
#             rm $file
#             ls -la /opt
#         done
#     else
#         sh /srp/opt/cpu_srp/update.sh
#     fi
# else
#     echo "SRP update not detected"
# fi

sh /srp/opt/cpu_srp/start_up.sh
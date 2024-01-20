 
#!/bin/sh
################################################################################
#
#   Copyright (c) 2024 Bartosz Snieg.
#
################################################################################
#
echo "Setting interface: eth0 for ec "
echo "ip: 192.168.10.101"
echo "net mask 255.255.255.0 "
ifconfig eth0 192.168.10.101 netmask 255.255.255.0
echo "Interface set [DONE]"
    
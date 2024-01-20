 
#!/bin/sh
################################################################################
#
#   Copyright (c) 2024 Bartosz Snieg.
#
################################################################################
#
echo "Simab SRP start up script"

sh /opt/cpu_simba/network_interface.sh
sh /opt/cpu_simba/component_start_up.sh

echo "Simab SRP start up script [DONE]"

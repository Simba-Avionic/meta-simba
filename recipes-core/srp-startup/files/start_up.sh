 #!/bin/bash
################################################################################
#
#   Copyright (c) 2024 Bartosz Snieg.
#
################################################################################
#
echo "Simab SRP start up script"

sh /srp/opt/cpu_srp/network_interface.sh
sh /srp/opt/cpu_srp/component_start_up.sh

echo "Simab SRP start up script [DONE]"

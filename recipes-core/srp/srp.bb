DESCRIPTION = "SRP Initscripts"
LICENSE = "CLOSED" 
 
SRC_URI += "\
    file://srp_start.sh \
    file://start_up.sh \
    file://network_interface.sh \
"
 
INITSCRIPT_NAME = "srp_start.sh" 
INITSCRIPT_PARAMS = "start 99 5 2 ." 
 
inherit update-rc.d 
 
S = "${WORKDIR}" 
 
do_install () { 
    install -d ${D}${sysconfdir}/init.d/ 
    install -c -m 755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME} 

    install -d ${D}/opt/cpu_simba

    install -m 0777 ${WORKDIR}/network_interface.sh ${D}/opt/cpu_simba
    install -m 0777 ${WORKDIR}/start_up.sh  ${D}/opt/cpu_simba

} 

DEPENDS = "bash"

RDEPENDS:${PN} = "bash"

FILES:${PN} += "\
    /opt/cpu_simba/start_up.sh \
    /opt/cpu_simba/network_interface.sh  \
"
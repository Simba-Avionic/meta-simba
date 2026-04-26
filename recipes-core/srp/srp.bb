DESCRIPTION = "SRP Initscripts"
LICENSE = "CLOSED" 
 
SRC_URI += "\
    file://srp_start.sh \
    file://start_up.sh \
    file://network_interface.sh \
"
 
INITSCRIPT_NAME = "srp_start.sh" 
INITSCRIPT_PARAMS = "start 1 S ." 
 
inherit update-rc.d 
 
S = "${WORKDIR}" 
 
do_install () { 
    
    install -d ${D}/srp
    install -d ${D}/srp/opt
    install -d ${D}/srp/opt/cpu_srp
    # install -d ${D}/persistance
    # install -d ${D}/logs
    chmod 0755 ${D}/srp
    # chmod 0666 ${D}/persistance
    # touch ${D}/persistance/.keep
    # chmod 0666 ${D}/logs
    # touch ${D}/logs/.keep
    install -d ${D}${sysconfdir}/init.d/ 
    install -c -m 755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME} 

    install -m 0755 ${WORKDIR}/network_interface.sh ${D}/srp/opt/cpu_srp
    install -m 0755 ${WORKDIR}/start_up.sh  ${D}/srp/opt/cpu_srp
} 

DEPENDS = "bash"

RDEPENDS:${PN} = "bash"

FILES:${PN} += "\
    /srp/opt/cpu_srp/start_up.sh \
    /srp/opt/cpu_srp/network_interface.sh  \
    # /persistance/.keep \
    # /logs/.keep \
"
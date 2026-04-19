SUMMARY = "SRP platform init"
LICENSE = "CLOSED"

SRC_URI += "\
    file://srp_start.sh \
    file://start_up.sh \
    file://network_interface.sh \
    file://srp_start.service \
"

INITSCRIPT_NAME = "srp_start"
INITSCRIPT_PARAMS = "start 99 5 2 ."

inherit systemd update-rc.d

SYSTEMD_SERVICE:${PN} = "\
                srp_start.service \
"

do_install:append() {

    install -d ${D}${systemd_system_unitdir}
    install -d ${D}${sysconfdir}/init.d
    install -d ${D}/bin
    install -d ${D}/opt/cpu_simba
    
    install -m 0777 ${WORKDIR}/srp_start.sh  ${D}/bin
    install -m 0755 ${WORKDIR}/srp_start.sh ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}

    install -m 0777 ${WORKDIR}/network_interface.sh ${D}/opt/cpu_simba
    install -m 0777 ${WORKDIR}/start_up.sh  ${D}/opt/cpu_simba

    install -m 0644 ${WORKDIR}/srp_start.service  ${D}${systemd_system_unitdir}
}

FILES:${PN} += "\
    /bin/srp_start.sh \
    ${sysconfdir}/init.d/${INITSCRIPT_NAME} \
    ${systemd_system_unitdir}/srp_start.service \
    /opt/cpu_simba/start_up.sh \
    /opt/cpu_simba/network_interface.sh  \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://config.cfg \
            file://0001-bus-config.patch file://0002-pin-config.patch \
            "


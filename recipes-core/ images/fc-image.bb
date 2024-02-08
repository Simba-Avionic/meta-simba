SUMMARY = "Flight computer image"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL} packagegroup-core-ssh-openssh kernel-modules i2c-tools libgpiod libgpiod-dev libgpiod-tools srp"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

DISTRO = "poky-tiny" 

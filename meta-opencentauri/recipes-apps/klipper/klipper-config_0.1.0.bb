SUMMARY = "Init script to setup klipper printer_data bind mount"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = "file://klipper-config-init-d"

S = "${WORKDIR}"

inherit update-rc.d allarch

INITSCRIPT_NAME = "klipper-config"
INITSCRIPT_PARAMS = "start 99 S . stop 01 6 ."

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/klipper-config-init-d ${D}${sysconfdir}/init.d/klipper-config
}

FILES:${PN} = "${sysconfdir}/init.d/klipper-config"

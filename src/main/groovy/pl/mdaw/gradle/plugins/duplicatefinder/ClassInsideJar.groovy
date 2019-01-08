package pl.mdaw.gradle.plugins.duplicatefinder

import java.util.zip.ZipEntry

class ClassInsideJar {
    String name
    String hashcode
    String filename

    ClassInsideJar(ZipEntry zipEntry, String filename) {
        name = zipEntry.name.substring(0, zipEntry.name.length() - 6).replaceAll('/', '.')
        hashcode = zipEntry.hashCode()
        this.filename = filename
    }

    boolean equals(object) {
        if (this.is(object)) return true
        if (getClass() != object.class) return false
        ClassInsideJar aClass = (ClassInsideJar) object
        if (name != aClass.name) return false
        return true
    }

    int hashCode() {
        return name.hashCode()
    }
}

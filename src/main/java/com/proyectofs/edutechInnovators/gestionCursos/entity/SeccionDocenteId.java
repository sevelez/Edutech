package com.proyectofs.edutechInnovators.gestionCursos.entity;

import java.io.Serializable;
import java.util.Objects;

public class SeccionDocenteId implements Serializable {
    private Long seccionId;
    private Long docenteId;

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeccionDocenteId that)) return false;
        return Objects.equals(seccionId, that.seccionId) &&
                Objects.equals(docenteId, that.docenteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seccionId, docenteId);
    }
}

package helper.model;

import helper.model.types.TypeDeclaration;
import java.nio.file.Path;

public record JavaFile(TypeDeclaration typeDeclaration, Path path) {
    @Override
    public String toString() {
        return typeDeclaration.toString();
    }
}

package helper.model.types;

import java.util.Objects;

public final class Record extends TypeDeclaration {
    private final String components;

    public Record(String name, String thePackage, AccessModifier accessModifier, String components) {
        super(name, thePackage, accessModifier);
        this.components = Objects.requireNonNull(components, "Параметр components не должен быть null!");
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(thePackage.isEmpty()? "\n" : "package " + thePackage + ";\n\n")
                .append(accessModifier)
                .append("record ")
                .append(name)
                .append('(')
                .append(components.isEmpty()? "" : components)
                .append(')')
                .append(" {\n}")
                .toString();
    }
}

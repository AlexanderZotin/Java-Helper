package helper.model.types;

import lombok.NonNull;

public final class Record extends TypeDeclaration {
    private final @NonNull String components;

    public Record(String name, String thePackage, AccessModifier accessModifier, String components) {
        super(name, thePackage, accessModifier);
        this.components = components;
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

package helper.model.types;

import java.util.Objects;

public final class Enum extends TypeDeclaration {
    private final String constants;

    public Enum(String name, String thePackage, AccessModifier accessModifier, String constants) {
        super(name, thePackage, accessModifier);
        this.constants = Objects.requireNonNull(constants, "Параметр constants не должен быть null!");
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(thePackage.isEmpty()? "\n" : "package " + thePackage + ";\n\n")
                .append(accessModifier)
                .append("enum ")
                .append(name)
                .append(" {\n")
                .append(constants.isEmpty()? "" : '\t' + constants + '\n')
                .append('}')
                .toString();
    }
}

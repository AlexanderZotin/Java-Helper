package helper.model.types;

import lombok.NonNull;

public final class Enum extends TypeDeclaration {
    private final @NonNull String constants;

    public Enum(String name, String thePackage, AccessModifier accessModifier, String constants) {
        super(name, thePackage, accessModifier);
        this.constants = constants;
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

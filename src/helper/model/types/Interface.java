package helper.model.types;

import java.util.Objects;

public final class Interface extends SealedAbleType {
    private final String parents;

    public Interface(String name, String thePackage, AccessModifier accessModifier, String parents, String permittedSubclasses) {
        super(name, thePackage, accessModifier, permittedSubclasses);
        this.parents = Objects.requireNonNull(parents, "Параметр parents не должен быть null!");
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(thePackage.isEmpty()? "\n" : "package " + thePackage + ";\n\n")
                .append(accessModifier)
                .append("interface ")
                .append(name)
                .append(parents.isEmpty()? "" : " extends " + parents)
                .append(permittedSubclasses.isEmpty()? "" : " permits " + permittedSubclasses)
                .append(" {\n}")
                .toString();
    }
}

package helper.model.types;

import lombok.NonNull;

public final class Interface extends SealedAbleType {
    private final @NonNull String parents;

    public Interface(String name, String thePackage, AccessModifier accessModifier, String parents, String permittedSubclasses) {
        super(name, thePackage, accessModifier, permittedSubclasses);
        this.parents = parents;
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

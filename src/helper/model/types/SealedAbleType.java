package helper.model.types;

import java.util.Objects;

public abstract sealed class SealedAbleType extends TypeDeclaration permits Class, Interface {
    protected final boolean isSealed;
    protected final String permittedSubclasses;

    public SealedAbleType(String name, String thePackage, AccessModifier accessModifier, String permittedSubclasses) {
        super(name, thePackage, accessModifier);
        this.permittedSubclasses = Objects.requireNonNull(permittedSubclasses,
                "Параметр permittedSubclasses не должен быть null!");
        isSealed = !this.permittedSubclasses.isEmpty();
    }
}

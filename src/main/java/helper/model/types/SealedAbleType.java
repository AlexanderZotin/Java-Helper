package helper.model.types;

import lombok.NonNull;

public abstract sealed class SealedAbleType extends TypeDeclaration permits Class, Interface {
    protected final boolean isSealed;
    protected final @NonNull String permittedSubclasses;

    public SealedAbleType(String name, String thePackage, AccessModifier accessModifier, String permittedSubclasses) {
        super(name, thePackage, accessModifier);
        this.permittedSubclasses = permittedSubclasses;
        isSealed = !this.permittedSubclasses.isEmpty();
    }
}

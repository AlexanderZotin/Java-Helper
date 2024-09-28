package helper.model.types;

import java.util.Objects;

public final class Class extends SealedAbleType {
    private final boolean isFinal;
    private final boolean isAbstract;
    private final String superClass;
    private final boolean createMain;
    private final boolean createConstructor;

    public Class(String name, String thePackage, AccessModifier accessModifier,
                 boolean isFinal, boolean isAbstract, String superClass, String permittedSubclasses,
                 boolean createMain, boolean createConstructor) {
        super(name, thePackage, accessModifier, permittedSubclasses);
        this.isFinal = isFinal;
        this.isAbstract = isAbstract;
        this.superClass = Objects.requireNonNull(superClass);
        this.createMain = createMain;
        this.createConstructor = createConstructor;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(thePackage.isEmpty()? "\n" : "package " + thePackage + ";\n\n")
                .append(accessModifier)
                .append(isAbstract? "abstract " : "")
                .append(isFinal? "final " : "")
                .append(permittedSubclasses.isEmpty()? "" : "sealed ")
                .append("class ")
                .append(name)
                .append(superClass.isEmpty()? "" : " extends " + superClass)
                .append(permittedSubclasses.isEmpty()? "" : " permits " + permittedSubclasses)
                .append(" {\n")
                .append(createConstructor? "\tpublic " + name + "() {\n\t}\n" : "")
                .append(createMain? "\tpublic static void main(String[] args) {\n\t}\n" : "")
                .append('}')
                .toString();
    }
}

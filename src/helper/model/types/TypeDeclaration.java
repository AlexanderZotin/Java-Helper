package helper.model.types;

import java.util.Objects;

public abstract sealed class TypeDeclaration permits SealedAbleType, Enum, Record {
   protected final String name;
   protected final String thePackage;
   protected final AccessModifier accessModifier;

   public enum AccessModifier {
      PUBLIC("public "), PACKAGE_PRIVATE("");

      private final String stringRepresentation;

      AccessModifier(String stringRepresentation) {
         this.stringRepresentation = stringRepresentation;
      }

      @Override
      public String toString() {
         return stringRepresentation;
      }
   }

   public TypeDeclaration(String name, String thePackage, AccessModifier accessModifier) {
      this.name = Objects.requireNonNull(name, "Параметр accessModifier не должен быть null!");
      this.thePackage = Objects.requireNonNull(thePackage, "Параметр thePackage не должен быть null!");
      this.accessModifier = Objects.requireNonNullElse(accessModifier, AccessModifier.PUBLIC);
   }

   public String getName() {
      return name;
   }

   public abstract String toString();
}

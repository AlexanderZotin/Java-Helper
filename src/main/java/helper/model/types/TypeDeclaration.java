package helper.model.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@NonNull
@AllArgsConstructor
public abstract sealed class TypeDeclaration permits SealedAbleType, Enum, Record {
   protected final @Getter String name;
   protected final String thePackage;
   protected final AccessModifier accessModifier;

   @AllArgsConstructor
   public enum AccessModifier {
      PUBLIC("public "), PACKAGE_PRIVATE("");

      private final String stringRepresentation;

      @Override
      public String toString() {
         return stringRepresentation;
      }
   }

   public abstract String toString();
}

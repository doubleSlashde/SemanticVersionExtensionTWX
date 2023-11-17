package de.ds.twx.server.extension;

import com.thingworx.metadata.annotations.ThingworxBaseTemplateDefinition;
import com.thingworx.metadata.annotations.ThingworxServiceDefinition;
import com.thingworx.metadata.annotations.ThingworxServiceParameter;
import com.thingworx.metadata.annotations.ThingworxServiceResult;
import com.thingworx.things.Thing;
import org.semver4j.Semver;

@ThingworxBaseTemplateDefinition(name = "GenericThing")
public class SemVerComparisonThing extends Thing {

   @ThingworxServiceDefinition(name = "IsGreaterThan", description = "Returns if version1 is greater than version2. Arguments must be valid semantic versions or exception will be thrown.")
   @ThingworxServiceResult(name = "result", baseType = "BOOLEAN")
   public boolean IsGreaterThan( //
         @ThingworxServiceParameter(name = "version1", aspects = { "isRequired:true"
         }, baseType = "STRING") String version1Param,//
         @ThingworxServiceParameter(name = "version2", aspects = { "isRequired:true"
         }, baseType = "STRING") String version2Param) {

      Semver version1 = parseStringToSemVerOrThrow(version1Param);
      Semver version2 = parseStringToSemVerOrThrow(version2Param);

      return version1.isGreaterThan(version2);
   }

   @ThingworxServiceDefinition(name = "IsGreaterThanOrEqualTo", description = "Returns if version1 is greater than or equal to version2. Arguments must be valid semantic versions or exception will be thrown.")
   @ThingworxServiceResult(name = "result", baseType = "BOOLEAN")
   public boolean IsGreaterThanOrEqualTo( //
         @ThingworxServiceParameter(name = "version1", aspects = { "isRequired:true"
         }, baseType = "STRING") String version1Param,//
         @ThingworxServiceParameter(name = "version2", aspects = { "isRequired:true"
         }, baseType = "STRING") String version2Param) {

      Semver version1 = parseStringToSemVerOrThrow(version1Param);
      Semver version2 = parseStringToSemVerOrThrow(version2Param);

      return version1.isGreaterThanOrEqualTo(version2);
   }

   @ThingworxServiceDefinition(name = "IsLowerThan", description = "Returns if version1 is greater than version2. Arguments must be valid semantic versions or exception will be thrown.")
   @ThingworxServiceResult(name = "result", baseType = "BOOLEAN")
   public boolean IsLowerThan( //
         @ThingworxServiceParameter(name = "version1", aspects = { "isRequired:true"
         }, baseType = "STRING") String version1Param,//
         @ThingworxServiceParameter(name = "version2", aspects = { "isRequired:true"
         }, baseType = "STRING") String version2Param) {

      Semver version1 = parseStringToSemVerOrThrow(version1Param);
      Semver version2 = parseStringToSemVerOrThrow(version2Param);

      return version1.isLowerThan(version2);
   }

   @ThingworxServiceDefinition(name = "IsLowerThanOrEqualTo", description = "Returns if version1 is lower than or equal to version2. Arguments must be valid semantic versions or exception will be thrown.")
   @ThingworxServiceResult(name = "result", baseType = "BOOLEAN")
   public boolean IsLowerThanOrEqualTo( //
         @ThingworxServiceParameter(name = "version1", aspects = { "isRequired:true"
         }, baseType = "STRING") String version1Param,//
         @ThingworxServiceParameter(name = "version2", aspects = { "isRequired:true"
         }, baseType = "STRING") String version2Param) {

      Semver version1 = parseStringToSemVerOrThrow(version1Param);
      Semver version2 = parseStringToSemVerOrThrow(version2Param);

      return version1.isLowerThanOrEqualTo(version2);
   }

   @ThingworxServiceDefinition(name = "IsEqualTo", description = "Returns if version1 is equal to version2. Arguments must be valid semantic versions or exception will be thrown.")
   @ThingworxServiceResult(name = "result", baseType = "BOOLEAN")
   public boolean IsEqualTo( //
         @ThingworxServiceParameter(name = "version1", aspects = { "isRequired:true"
         }, baseType = "STRING") String version1Param,//
         @ThingworxServiceParameter(name = "version2", aspects = { "isRequired:true"
         }, baseType = "STRING") String version2Param) {

      Semver version1 = parseStringToSemVerOrThrow(version1Param);
      Semver version2 = parseStringToSemVerOrThrow(version2Param);

      return version1.isEqualTo(version2);
   }

   @ThingworxServiceDefinition(name = "Coerce", description = "Coerce string into semver if is possible. Otherwise an exception will be thrown.")
   @ThingworxServiceResult(name = "result", baseType = "STRING")
   public String Coerce( //
         @ThingworxServiceParameter(name = "version", aspects = { "isRequired:true"
         }, baseType = "STRING") String versionParam) {
      if (versionParam == null) {
         throw new IllegalArgumentException("Given version '" + null + "' could not be forced into a valid semver.");
      }

      Semver ver = Semver.coerce(versionParam);
      if (ver == null) {
         throw new IllegalArgumentException(
               "Given version '" + versionParam + "' could not be forced into a valid semver.");
      }

      return ver.toString();
   }

   @ThingworxServiceDefinition(name = "IsValid", description = "Checks is given string version is valid.")
   @ThingworxServiceResult(name = "result", baseType = "BOOLEAN")
   public boolean IsValid( //
         @ThingworxServiceParameter(name = "version", aspects = { "isRequired:true"
         }, baseType = "STRING") String versionParam) {
      return Semver.isValid(versionParam);
   }

   @ThingworxServiceDefinition(name = "IsStable", description = "Determines if the current version is stable or not. Stable version have a major version number strictly positive  and no pre-release tokens .")
   @ThingworxServiceResult(name = "result", baseType = "BOOLEAN")
   public boolean IsStable( //
         @ThingworxServiceParameter(name = "version", aspects = { "isRequired:true"
         }, baseType = "STRING") String versionParam) {
      return parseStringToSemVerOrThrow(versionParam).isStable();
   }

   private Semver parseStringToSemVerOrThrow(String version) {
      if (!Semver.isValid(version)) {
         throw new IllegalArgumentException("Given version '" + version + "' is not a valid semantic version.");
      }
      return Semver.parse(version);
   }
}

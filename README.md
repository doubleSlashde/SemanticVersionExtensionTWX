# Semantic Version Comparison Extension ThingWorx

This extension uses the [Semver4j](https://github.com/semver4j/semver4j) library to provide services for validating and comparing semantic versions in your ThinWorx applications.

## Features
- Version Validation: Validates if a given version string follows the rules of the semantic versioning specification.
- Version Comparison: Allows you to compare different semantic versions.
- Version Stability Check: Checks if a given semantic version is stable.
- **not implemented** Version Difference: Provides the main difference between two semantic versions.
- **not implemented** Version Range Checking: Checks if a version satisfies a range.

## Installation
- Download the Extension .zip from releases
- Before importing consider the warning of PTC regarding extenions
   - "Custom code imported into ThingWorx can powerfully impact the behavior of the platform. PTC strongly advises you to evaluate the source and content of any extensions you import in order to ensure there is no malicious or otherwise unintended code present."
- Import into your ThingWorx instance

## Usage
After importing the extension a ThingTemplate `DS.TT.SemVerComparison` exists which offers the services. An instance of that ThingTemplate does also already exist `DS.T.SemVer`.
You can use the Thing directly in your code, to not create a direct dependency to the extension.

![Services available](readme/twx_services.png?raw=true)

## Contributing
Feel free to contribute to this project by creating pull requests or reporting bugs. If you have suggestions for new features, please open an issue.

## Build
To build the project locally you will need to download the ThingWorx Extension SDK and extract the twx-lib into folder twx-lib.
After that you can run e.g.
```
./gradlew clean
./gradlew build -PPACKAGE_VERSION=1.0.5 -PBUILD_NUMBER=5 -PBUILD_SOURCEVERSION=GitCommitSha -PallEditable=false
```
To run gradle in two steps is currently needed as otherwise the semver4j.jar will not be existent in the resulting extension .zip.

### Supported Environment variables / Project properties

- `PACKAGE_VERSION`: Version of the extension. Defaults to `0.yyyyMMdd.MMhhss`
- `BUILD_NUMBER`: The CI Build ID. Defaults to `SNAPSHOT - yyyyMMddHHmmss`
- `BUILD_SOURCEVERSION`: The SHA of the commit which was used to build the extension. Defaults to `SNAPSHOT`

- `allEditable`=true: Will set all entities editable, not only those which have tag **DS:isEditable**. If true the file name will end with '-editable.zip' - otherwise '-regular.zip'.

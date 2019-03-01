# Plexus Container Five Minute Tutorial

This is the output of [Plexus Container Five Minute Tutorial](
https://blog.sonatype.com/2009/05/plexus-container-five-minute-tutorial/).

## Compile

Run `process-classes`.

```
~/hello-plexus-container$ mvn process-classes
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------< com.google.suztomo:hello-plexus-container >--------------
[INFO] Building hello-plexus-container 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ hello-plexus-container ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /usr/local/google/home/suztomo/hello-plexus-container/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ hello-plexus-container ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 6 source files to /usr/local/google/home/suztomo/hello-plexus-container/target/classes
[INFO] 
[INFO] --- plexus-component-metadata:1.7.1:generate-metadata (process-classes) @ hello-plexus-container ---
[INFO] Discovered 3 component descriptors(s)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.885 s
[INFO] Finished at: 2019-03-01T10:02:19-05:00
[INFO] ------------------------------------------------------------------------
```

This phase generates `components.xml` in `target` directory:

```
~/hello-plexus-container$ head target/components.xml 
<component-set>
  <components>
    <component>
      <role>example.Cheese</role>
      <role-hint>parmesan</role-hint>
      <implementation>example.ParmesanCheese</implementation>
      <description></description>
      <isolated-realm>false</isolated-realm>
    </component>
    <component>
```

This `components.xml` declares how to prepare objects for Plexus Containers. Without the xml, you
will get an error with the lookup at runtime:

```
ComponentLookupException: Component descriptor cannot be found in the component repository
      role: example.Plate
```

## Run

```
~/hello-plexus-container$ mvn exec:java
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------< com.google.suztomo:hello-plexus-container >--------------
[INFO] Building hello-plexus-container 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ hello-plexus-container ---
americanCheese smells like: plastic
moreAmericanCheese smells like: plastic
parmesanCheese smells : strong

The List of cheeses has:
cheese: AmericanCheese
cheese: ParmesanCheese

The Map contains:
hint: default, value: AmericanCheese
hint: parmesan, value: ParmesanCheese
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.473 s
[INFO] Finished at: 2019-03-01T10:03:47-05:00
[INFO] ------------------------------------------------------------------------
```
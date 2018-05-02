@ECHO OFF
for %%f in (target\*.jar) do (
	java -jar %%f
)
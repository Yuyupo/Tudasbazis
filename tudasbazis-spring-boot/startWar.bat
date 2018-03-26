@ECHO OFF
for %%f in (target\*.war) do (
	java -jar %%f
)
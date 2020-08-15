no_default:
	@echo "no default target"

clean:
	@mvn -f $(CURDIR)/pom.xml clean -q

deploy:
	@mvn -f $(CURDIR)/pom.xml clean deploy -P Sonar

install:
	@mvn -f $(CURDIR)/pom.xml clean install

github: clean
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"

.PHONY: no_default clean install deploy github
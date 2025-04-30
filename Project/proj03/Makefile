SRC_DIR:=src
CLASS_DIR:=class
# TARGET_DIR:=target
TARGET_DIR:=.
MAIN_CLASS:=GibberisherMain
JAR_NAME:=$(TARGET_DIR)/proj03.jar

JAVAC?=javac
JAR?=jar

SOURCES:=$(wildcard $(SRC_DIR)/*.java)
CLASSES:=$(SOURCES:$(SRC_DIR)/%.java=$(CLASS_DIR)/%.class)


.PHONY: all

all: $(JAR_NAME)

$(CLASS_DIR)/%.class: $(SRC_DIR)/%.java | dirs
	$(JAVAC) -d $(CLASS_DIR) -cp $(CLASS_DIR) -sourcepath $(SRC_DIR) $<

$(JAR_NAME): $(CLASSES) | dirs
	$(JAR) -c -f $@ -e $(MAIN_CLASS) -C $(CLASS_DIR) .


.PHONY: run clean dirs

run: $(JAR_NAME)
	java -jar $(JAR_NAME)

clean:
	rm -rf $(CLASS_DIR) $(JAR_NAME)

dirs:
	@mkdir -p $(CLASS_DIR) $(TARGET_DIR)


.PHONY: run-%

run-%: $(CLASSES)
	@echo "=> running $*"
	java -cp $(JAR_NAME) $*


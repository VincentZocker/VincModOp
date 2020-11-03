package info.vincent.vincmodop.reference;

public class Reference {
    public static final String MODID = "vincmodop";
    public static final String REIGSTRY_NAME_WITHERBOW_ITEM = "witherbowitem"; // must be the same like witherbowitem.json

    public static enum TEAM_OPTION_BUTTONS {
        INFINATE_BARRACKS_QUEUE, INFINANTE_ARCHERY_RANGE_QUEUE, INFINANTE_STABLES_QUEUE, INFINANTE_SIEGE_WORKSHOP_QUEUE, INFINANTE_TEMPLE_QUEUE
    }

    public static enum STRUCTURE_TYPE {
        ARCHERY_RANGE, ARMORY, BARRACKS, FARM, GATE, LUMBER_YARD, MARKETPLACE, MINE_SITE_STONE, MINE_SITE_IRON, MINE_SITE_GOLD, MINE_SITE_DIAMOND, MINE_SITE_EMERALD, RESEARCH_CENTER, SIEGE_WORKSHOP, STABLES, TOWN_HALL, TEMPLE, WALL_STEPS, WALL, WATCH_TOWER
    }

    public static enum RTS_COSTS {
        ARMORY, MINION, ARCHER, LANCER, PIKEMAN, FARM, LUMBER_YARD, MARKETPLACE, MINE_STONE, MINE_IRON, MINE_GOLD, MINE_DIAMOND, MINE_EMERALD, BARRACKS, ARCHERY_RANGE, WALL, WALL_STEPS, GATE, RESEARCH_CENTER, STABLES, WATCH_TOWER, RESEARCH_TOWNHALL, RESEARCH_MINION, RESEARCH_ARCHER, RESEARCH_PIKEMAN, RESEARCH_LANCER, RESEARCH_BLACKSMITHING, RESEARCH_ARMOR, RESEARCH_MARKETPLACE, RESEARCH_WALL, RESEARCH_SIEGE_WORKSHOP, RESEARCH_CROSSBOW, RESEARCH_ADVANCED_ARMOR, RESEARCH_WATCHTOWER, RESEARCH_BATTERING_RAM, RESEARCH_TREBUCHET, SIEGE_WORKSHOP, SAPPER, LONGBOWMEN, CROSSBOWMEN, CLERIC
    }

    public static enum UNIT_TYPES {

        MINION("Minion", null, false, 0, 3), ARCHER("Archer", "archer", false, 1, 3), LANCER("Lancer", "lancer", false, 2, 3), PIKEMAN("Pikeman", "pikeman", true, 3, 3), KNIGHT("Knight", "armor", true, 5, 3), ADVANCED_KNIGHT("AdvancedKnight", "advcedarmor", true, 6, 3), SAPPER("Sapper", "siegeworkshop", false, 4, 1), TREBUCHET("Trebuchet", null, false, 0, 0), LONGBOWMAN("Longbowmen", "longbows", false, 5, 1), CROSSBOWMAN("Crossbowmen", "crossbows", false, 6, 1), CLERIC("Cleric", null, false, 7, 1);

        private String Name;
        private String ResearchKeyRequiredToBuy;
        private boolean ArmoryRequired = false;
        private int buttonImageX;
        private int buttonImageY;

        private UNIT_TYPES(String Name, String ResearchKeyRequiredToBuy, boolean ArmoryRequired, int buttonImageX, int buttonImageY) {
            this.Name = Name;
            this.ResearchKeyRequiredToBuy = ResearchKeyRequiredToBuy;
            this.ArmoryRequired = ArmoryRequired;
            this.buttonImageX = buttonImageX;
            this.buttonImageY = buttonImageY;
        }

        public int getButtonImageY() {
            return buttonImageY;
        }

        public int getButtonImageX() {
            return buttonImageX;
        }

        public String getResearchKeyRequiredToBuy() {
            return ResearchKeyRequiredToBuy;
        }

        public String getName() {
            return Name;
        }

        public boolean IsArmoryRquired() {
            return ArmoryRequired;
        }

    }
}

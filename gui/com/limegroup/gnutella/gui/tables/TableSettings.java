package com.limegroup.gnutella.gui.tables;

import org.limewire.setting.BooleanSetting;
import org.limewire.setting.IntSetting;
import org.limewire.setting.SettingsFactory;

import com.limegroup.gnutella.settings.TablesHandlerSettings;

/**
 * Manages settings for tables and their associated components.
 */
public class TableSettings {
    
    /**
     * The SettingsFactory settings will be added/read to/from.
     */
    protected static final SettingsFactory FACTORY = TablesHandlerSettings.instance().getFactory();    
    
    public static final IntSetting DEFAULT_TABLE_ROW_HEIGHT = FACTORY.createIntSetting("TABLE_ROW_HEIGHT",22);
    
    /**
     * Additions to the ID to identify the setting.
     */
    private static final String SORT = "_SORT";
    private static final String TOOLTIP = " _TOOLTIP";
    
    /**
     * The setting for whether or not to sort in real time.
     */
    public BooleanSetting REAL_TIME_SORT;
    
    /**
     * The setting for whether or not to display tooltips.
     */
    public BooleanSetting DISPLAY_TOOLTIPS;
    
    /**
     * The id of this settings object.
     */
    private final String ID;
    
    /**
     * Constructs a new TableSettings whose settings
     * are identified by the specified ID.
     */
    public TableSettings(String id) {
        ID = id;
        REAL_TIME_SORT = FACTORY.createBooleanSetting(id + SORT, getDefaultSorting());
        DISPLAY_TOOLTIPS = FACTORY.createBooleanSetting(id + TOOLTIP, getDefaultTooltips());
    }
    
    /**
     * Gets the ID of this TableSettings object.
     */
    public String getID() {
        return ID;
    }
    
    /**
     * Returns the default value for row striping.
     */
    protected boolean getDefaultRowStripe() {
        return true;
    }
    
    /**
     * Returns the default value for sorting.
     */
    protected boolean getDefaultSorting() {
        return true;
    }
    
    /**
     * Returns the default value for displaying tooltips.
     */
    protected boolean getDefaultTooltips() {
        return true;
    }
    
    /**
     * Reverts all options to their default for this table.
     */
    public void revertToDefault() {
        REAL_TIME_SORT.revertToDefault();
        DISPLAY_TOOLTIPS.revertToDefault();
    }
    
    /**
     * Determines if all the options are already at their defaults.
     */
    public boolean isDefault() {
        return REAL_TIME_SORT.isDefault() && DISPLAY_TOOLTIPS.isDefault();
    }
}


package xyz.someboringnerd;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.someboringnerd.listener.ItemFrameListener;

public final class ItemFrameDupe extends JavaPlugin {

    public static FileConfiguration config;

    public void saveTheConfigFile(){
        saveConfig();
    }

    @Override
    public void onEnable() {
        System.out.println("ItemFrameDupe by SomeBoringNerd for 4b4f");
        getServer().getPluginManager().registerEvents(new ItemFrameListener(), this);

        config = this.getConfig();
        config.addDefault("probability", 10);			//% de chance que le dupe se fasse
    }
}

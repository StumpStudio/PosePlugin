package net.minecraft.server.v1_17_R1;

import com.google.common.collect.ImmutableList;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.block.data.BlockData;
import org.bukkit.boss.*;
import org.bukkit.command.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.*;
import org.bukkit.loot.LootTable;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.armagidon.poseplugin.api.utils.nms.classes.MockedPluginManager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class MockedServer implements Server
{

    private final PluginManager manager = new MockedPluginManager(this);

    @Override
    public @NotNull String getName() {
        return null;
    }

    @Override
    public @NotNull String getVersion() {
        return "1.17";
    }

    @Override
    public @NotNull String getBukkitVersion() {
        return "1.17";
    }

    @Override
    public @NotNull Collection<? extends Player> getOnlinePlayers() {
        return ImmutableList.of();
    }

    @Override
    public int getMaxPlayers() {
        return 0;
    }

    @Override
    public int getPort() {
        return 0;
    }

    @Override
    public int getViewDistance() {
        return 0;
    }

    @Override
    public @NotNull String getIp() {
        return null;
    }

    @Override
    public @NotNull String getWorldType() {
        return null;
    }

    @Override
    public boolean getGenerateStructures() {
        return false;
    }

    @Override
    public int getMaxWorldSize() {
        return 0;
    }

    @Override
    public boolean getAllowEnd() {
        return false;
    }

    @Override
    public boolean getAllowNether() {
        return false;
    }

    @Override
    public boolean hasWhitelist() {
        return false;
    }

    @Override
    public void setWhitelist(boolean b) {

    }

    @Override
    public @NotNull Set<OfflinePlayer> getWhitelistedPlayers() {
        return null;
    }

    @Override
    public void reloadWhitelist() {

    }

    @Override
    public int broadcastMessage(@NotNull String s) {
        return 0;
    }

    @Override
    public @NotNull String getUpdateFolder() {
        return null;
    }

    @Override
    public @NotNull File getUpdateFolderFile() {
        return null;
    }

    @Override
    public long getConnectionThrottle() {
        return 0;
    }

    @Override
    public int getTicksPerAnimalSpawns() {
        return 0;
    }

    @Override
    public int getTicksPerMonsterSpawns() {
        return 0;
    }

    @Override
    public int getTicksPerWaterSpawns() {
        return 0;
    }

    @Override
    public int getTicksPerWaterAmbientSpawns() {
        return 0;
    }

    @Override
    public int getTicksPerAmbientSpawns() {
        return 0;
    }

    @Override
    public @Nullable Player getPlayer(@NotNull String s) {
        return null;
    }

    @Override
    public @Nullable Player getPlayerExact(@NotNull String s) {
        return null;
    }

    @Override
    public @NotNull List<Player> matchPlayer(@NotNull String s) {
        return null;
    }

    @Override
    public @Nullable Player getPlayer(@NotNull UUID uuid) {
        return null;
    }

    @Override
    public @NotNull PluginManager getPluginManager() {
        return manager;
    }

    @Override
    public @NotNull BukkitScheduler getScheduler() {
        return new BukkitScheduler() {
            @Override
            public int scheduleSyncDelayedTask(@NotNull Plugin plugin, @NotNull Runnable runnable, long l) {
                return 0;
            }

            @Override
            public int scheduleSyncDelayedTask(@NotNull Plugin plugin, @NotNull BukkitRunnable bukkitRunnable, long l) {
                return 0;
            }

            @Override
            public int scheduleSyncDelayedTask(@NotNull Plugin plugin, @NotNull Runnable runnable) {
                return 0;
            }

            @Override
            public int scheduleSyncDelayedTask(@NotNull Plugin plugin, @NotNull BukkitRunnable bukkitRunnable) {
                return 0;
            }

            @Override
            public int scheduleSyncRepeatingTask(@NotNull Plugin plugin, @NotNull Runnable runnable, long l, long l1) {
                return 0;
            }

            @Override
            public int scheduleSyncRepeatingTask(@NotNull Plugin plugin, @NotNull BukkitRunnable bukkitRunnable, long l, long l1) {
                return 0;
            }

            @Override
            public int scheduleAsyncDelayedTask(@NotNull Plugin plugin, @NotNull Runnable runnable, long l) {
                return 0;
            }

            @Override
            public int scheduleAsyncDelayedTask(@NotNull Plugin plugin, @NotNull Runnable runnable) {
                return 0;
            }

            @Override
            public int scheduleAsyncRepeatingTask(@NotNull Plugin plugin, @NotNull Runnable runnable, long l, long l1) {
                return 0;
            }

            @Override
            public @NotNull <T> Future<T> callSyncMethod(@NotNull Plugin plugin, @NotNull Callable<T> callable) {
                return null;
            }

            @Override
            public void cancelTask(int i) {

            }

            @Override
            public void cancelTasks(@NotNull Plugin plugin) {

            }

            @Override
            public boolean isCurrentlyRunning(int i) {
                return false;
            }

            @Override
            public boolean isQueued(int i) {
                return false;
            }

            @Override
            public @NotNull List<BukkitWorker> getActiveWorkers() {
                return null;
            }

            @Override
            public @NotNull List<BukkitTask> getPendingTasks() {
                return null;
            }

            @Override
            public @NotNull BukkitTask runTask(@NotNull Plugin plugin, @NotNull Runnable runnable) throws IllegalArgumentException {
                return null;
            }

            @Override
            public void runTask(@NotNull Plugin plugin, @NotNull Consumer<BukkitTask> consumer) throws IllegalArgumentException {

            }

            @Override
            public @NotNull BukkitTask runTask(@NotNull Plugin plugin, @NotNull BukkitRunnable bukkitRunnable) throws IllegalArgumentException {
                return null;
            }

            @Override
            public @NotNull BukkitTask runTaskAsynchronously(@NotNull Plugin plugin, @NotNull Runnable runnable) throws IllegalArgumentException {
                return null;
            }

            @Override
            public void runTaskAsynchronously(@NotNull Plugin plugin, @NotNull Consumer<BukkitTask> consumer) throws IllegalArgumentException {

            }

            @Override
            public @NotNull BukkitTask runTaskAsynchronously(@NotNull Plugin plugin, @NotNull BukkitRunnable bukkitRunnable) throws IllegalArgumentException {
                return null;
            }

            @Override
            public @NotNull BukkitTask runTaskLater(@NotNull Plugin plugin, @NotNull Runnable runnable, long l) throws IllegalArgumentException {
                return null;
            }

            @Override
            public void runTaskLater(@NotNull Plugin plugin, @NotNull Consumer<BukkitTask> consumer, long l) throws IllegalArgumentException {

            }

            @Override
            public @NotNull BukkitTask runTaskLater(@NotNull Plugin plugin, @NotNull BukkitRunnable bukkitRunnable, long l) throws IllegalArgumentException {
                return null;
            }

            @Override
            public @NotNull BukkitTask runTaskLaterAsynchronously(@NotNull Plugin plugin, @NotNull Runnable runnable, long l) throws IllegalArgumentException {
                return null;
            }

            @Override
            public void runTaskLaterAsynchronously(@NotNull Plugin plugin, @NotNull Consumer<BukkitTask> consumer, long l) throws IllegalArgumentException {

            }

            @Override
            public @NotNull BukkitTask runTaskLaterAsynchronously(@NotNull Plugin plugin, @NotNull BukkitRunnable bukkitRunnable, long l) throws IllegalArgumentException {
                return null;
            }

            @Override
            public @NotNull BukkitTask runTaskTimer(@NotNull Plugin plugin, @NotNull Runnable runnable, long l, long l1) throws IllegalArgumentException {
                return null;
            }

            @Override
            public void runTaskTimer(@NotNull Plugin plugin, @NotNull Consumer<BukkitTask> consumer, long l, long l1) throws IllegalArgumentException {

            }

            @Override
            public @NotNull BukkitTask runTaskTimer(@NotNull Plugin plugin, @NotNull BukkitRunnable bukkitRunnable, long l, long l1) throws IllegalArgumentException {
                return null;
            }

            @Override
            public @NotNull BukkitTask runTaskTimerAsynchronously(@NotNull Plugin plugin, @NotNull Runnable runnable, long l, long l1) throws IllegalArgumentException {
                return null;
            }

            @Override
            public void runTaskTimerAsynchronously(@NotNull Plugin plugin, @NotNull Consumer<BukkitTask> consumer, long l, long l1) throws IllegalArgumentException {

            }

            @Override
            public @NotNull BukkitTask runTaskTimerAsynchronously(@NotNull Plugin plugin, @NotNull BukkitRunnable bukkitRunnable, long l, long l1) throws IllegalArgumentException {
                return null;
            }
        };
    }

    @Override
    public @NotNull ServicesManager getServicesManager() {
        return null;
    }

    @Override
    public @NotNull List<World> getWorlds() {
        return null;
    }

    @Override
    public @Nullable World createWorld(@NotNull WorldCreator worldCreator) {
        return null;
    }

    @Override
    public boolean unloadWorld(@NotNull String s, boolean b) {
        return false;
    }

    @Override
    public boolean unloadWorld(@NotNull World world, boolean b) {
        return false;
    }

    @Override
    public @Nullable World getWorld(@NotNull String s) {
        return null;
    }

    @Override
    public @Nullable World getWorld(@NotNull UUID uuid) {
        return null;
    }

    @Override
    public @Nullable MapView getMap(int i) {
        return null;
    }

    @Override
    public @NotNull MapView createMap(@NotNull World world) {
        return null;
    }

    @Override
    public @NotNull ItemStack createExplorerMap(@NotNull World world, @NotNull Location location, @NotNull StructureType structureType) {
        return null;
    }

    @Override
    public @NotNull ItemStack createExplorerMap(@NotNull World world, @NotNull Location location, @NotNull StructureType structureType, int i, boolean b) {
        return null;
    }

    @Override
    public void reload() {

    }

    @Override
    public void reloadData() {

    }

    @Override
    public @NotNull Logger getLogger() {
        return Logger.getLogger("[]");
    }

    @Override
    public @Nullable PluginCommand getPluginCommand(@NotNull String s) {
        return null;
    }

    @Override
    public void savePlayers() {

    }

    @Override
    public boolean dispatchCommand(@NotNull CommandSender commandSender, @NotNull String s) throws CommandException {
        return false;
    }

    @Override
    public boolean addRecipe(@Nullable Recipe recipe) {
        return false;
    }

    @Override
    public @NotNull List<Recipe> getRecipesFor(@NotNull ItemStack itemStack) {
        return null;
    }

    @Override
    public @Nullable Recipe getRecipe(@NotNull NamespacedKey namespacedKey) {
        return null;
    }

    @Override
    public @NotNull Iterator<Recipe> recipeIterator() {
        return null;
    }

    @Override
    public void clearRecipes() {

    }

    @Override
    public void resetRecipes() {

    }

    @Override
    public boolean removeRecipe(@NotNull NamespacedKey namespacedKey) {
        return false;
    }

    @Override
    public @NotNull Map<String, String[]> getCommandAliases() {
        return null;
    }

    @Override
    public int getSpawnRadius() {
        return 0;
    }

    @Override
    public void setSpawnRadius(int i) {

    }

    @Override
    public boolean getOnlineMode() {
        return false;
    }

    @Override
    public boolean getAllowFlight() {
        return false;
    }

    @Override
    public boolean isHardcore() {
        return false;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public int broadcast(@NotNull String s, @NotNull String s1) {
        return 0;
    }

    @Override
    public @NotNull OfflinePlayer getOfflinePlayer(@NotNull String s) {
        return null;
    }

    @Override
    public @NotNull OfflinePlayer getOfflinePlayer(@NotNull UUID uuid) {
        return null;
    }

    @Override
    public @NotNull Set<String> getIPBans() {
        return null;
    }

    @Override
    public void banIP(@NotNull String s) {

    }

    @Override
    public void unbanIP(@NotNull String s) {

    }

    @Override
    public @NotNull Set<OfflinePlayer> getBannedPlayers() {
        return null;
    }

    @Override
    public @NotNull BanList getBanList(BanList.Type type) {
        return null;
    }

    @Override
    public @NotNull Set<OfflinePlayer> getOperators() {
        return null;
    }

    @Override
    public @NotNull GameMode getDefaultGameMode() {
        return null;
    }

    @Override
    public void setDefaultGameMode(@NotNull GameMode gameMode) {

    }

    @Override
    public @NotNull ConsoleCommandSender getConsoleSender() {
        return null;
    }

    @Override
    public @NotNull File getWorldContainer() {
        return null;
    }

    @Override
    public @NotNull
    OfflinePlayer[] getOfflinePlayers() {
        return new OfflinePlayer[0];
    }

    @Override
    public @NotNull Messenger getMessenger() {
        return null;
    }

    @Override
    public @NotNull HelpMap getHelpMap() {
        return null;
    }

    @Override
    public @NotNull Inventory createInventory(@Nullable InventoryHolder inventoryHolder, @NotNull InventoryType inventoryType) {
        return null;
    }

    @Override
    public @NotNull Inventory createInventory(@Nullable InventoryHolder inventoryHolder, @NotNull InventoryType inventoryType, @NotNull String s) {
        return null;
    }

    @Override
    public @NotNull Inventory createInventory(@Nullable InventoryHolder inventoryHolder, int i) throws IllegalArgumentException {
        return null;
    }

    @Override
    public @NotNull Inventory createInventory(@Nullable InventoryHolder inventoryHolder, int i, @NotNull String s) throws IllegalArgumentException {
        return null;
    }

    @Override
    public @NotNull Merchant createMerchant(@Nullable String s) {
        return null;
    }

    @Override
    public int getMonsterSpawnLimit() {
        return 0;
    }

    @Override
    public int getAnimalSpawnLimit() {
        return 0;
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        return 0;
    }

    @Override
    public int getWaterAmbientSpawnLimit() {
        return 0;
    }

    @Override
    public int getAmbientSpawnLimit() {
        return 0;
    }

    @Override
    public boolean isPrimaryThread() {
        return false;
    }

    @Override
    public @NotNull String getMotd() {
        return null;
    }


    @Override
    public @Nullable String getShutdownMessage() {
        return null;
    }

    @Override
    public Warning. WarningState getWarningState() {
        return null;
    }

    @Override
    public @NotNull ItemFactory getItemFactory() {
        return null;
    }

    @Override
    public @NotNull ScoreboardManager getScoreboardManager() {
        return null;
    }

    @Override
    public @Nullable CachedServerIcon getServerIcon() {
        return null;
    }

    @Override
    public @NotNull CachedServerIcon loadServerIcon(@NotNull File file) throws IllegalArgumentException, Exception {
        return null;
    }

    @Override
    public @NotNull CachedServerIcon loadServerIcon(@NotNull BufferedImage bufferedImage) throws IllegalArgumentException, Exception {
        return null;
    }

    @Override
    public void setIdleTimeout(int i) {

    }

    @Override
    public int getIdleTimeout() {
        return 0;
    }

    @Override
    public ChunkGenerator. ChunkData createChunkData(@NotNull World world) {
        return null;
    }

    @Override
    public @NotNull BossBar createBossBar(@Nullable String s, @NotNull BarColor barColor, @NotNull BarStyle barStyle, @NotNull BarFlag... barFlags) {
        return null;
    }

    @Override
    public @NotNull KeyedBossBar createBossBar(@NotNull NamespacedKey namespacedKey, @Nullable String s, @NotNull BarColor barColor, @NotNull BarStyle barStyle, @NotNull BarFlag... barFlags) {
        return null;
    }

    @Override
    public @NotNull Iterator<KeyedBossBar> getBossBars() {
        return null;
    }

    @Override
    public @Nullable KeyedBossBar getBossBar(@NotNull NamespacedKey namespacedKey) {
        return null;
    }

    @Override
    public boolean removeBossBar(@NotNull NamespacedKey namespacedKey) {
        return false;
    }

    @Override
    public @Nullable Entity getEntity(@NotNull UUID uuid) {
        return null;
    }

    @Override
    public @Nullable Advancement getAdvancement(@NotNull NamespacedKey namespacedKey) {
        return null;
    }

    @Override
    public @NotNull Iterator<Advancement> advancementIterator() {
        return null;
    }

    @Override
    public @NotNull BlockData createBlockData(@NotNull Material material) {
        return null;
    }

    @Override
    public @NotNull BlockData createBlockData(@NotNull Material material, @Nullable Consumer<BlockData> consumer) {
        return null;
    }

    @Override
    public @NotNull BlockData createBlockData(@NotNull String s) throws IllegalArgumentException {
        return null;
    }

    @Override
    public @NotNull BlockData createBlockData(@Nullable Material material, @Nullable String s) throws IllegalArgumentException {
        return null;
    }

    @Override
    public <T extends Keyed> Tag<T> getTag(@NotNull String s, @NotNull NamespacedKey namespacedKey, @NotNull Class<T> aClass) {
        return null;
    }

    @Override
    public @NotNull <T extends Keyed> Iterable<Tag<T>> getTags(@NotNull String s, @NotNull Class<T> aClass) {
        return null;
    }

    @Override
    public @Nullable LootTable getLootTable(@NotNull NamespacedKey namespacedKey) {
        return null;
    }

    @Override
    public @NotNull List<Entity> selectEntities(@NotNull CommandSender commandSender, @NotNull String s) throws IllegalArgumentException {
        return null;
    }

    @Override
    public @NotNull UnsafeValues getUnsafe() {
        return null;
    }

    @Override
    public @NotNull Spigot spigot() {
        return null;
    }

    @Override
    public void sendPluginMessage(@NotNull Plugin plugin, @NotNull String s, @NotNull byte[] bytes) {

    }

    @Override
    public @NotNull Set<String> getListeningPluginChannels() {
        return null;
    }
}

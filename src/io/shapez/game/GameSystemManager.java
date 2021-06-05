package io.shapez.game;

import io.shapez.game.systems.*;

import java.io.IOException;

public class GameSystemManager {
    private final GameRoot root;
    public BeltSystem belt;
    public BeltUnderlaysSystem beltUnderlays;
    public ItemAcceptorSystem itemAcceptor;
    public StaticMapEntitySystem staticMapEntities;
    public LeverSystem lever;
    public DisplaySystem display;
    public ItemProcessorSystem itemProcessor;
    public FilterSystem filter;
    ItemEjectorSystem itemEjector;
    final MapResourcesSystem mapResources;
    MinerSystem miner;

    public GameSystemManager(final GameRoot root) throws IOException {
        this.root = root;
        mapResources = new MapResourcesSystem(root);
        belt = new BeltSystem(root);
        itemEjector = new ItemEjectorSystem(root);
        miner = new MinerSystem(root);
        beltUnderlays = new BeltUnderlaysSystem(root);
        itemAcceptor = new ItemAcceptorSystem(root);
        staticMapEntities = new StaticMapEntitySystem(root);
        lever = new LeverSystem(root);
        display = new DisplaySystem(root);
        itemProcessor = new ItemProcessorSystem(root);
    }

    public void update() {
        itemAcceptor.update();
        belt.update();
    }
}

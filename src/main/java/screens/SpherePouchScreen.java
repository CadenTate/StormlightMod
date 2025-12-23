package screens;

import ctnightfury.stormlightmod.StormlightMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SpherePouchScreen extends HandledScreen<SpherePouchScreenHandler>{
    private static final Identifier TEXTURE = Identifier.of(StormlightMod.MOD_ID, "textures/gui/container/sphere_pouch.png");
    private final int rows;

    // TODO: Update screen writing code

    public SpherePouchScreen(SpherePouchScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.rows = handler.getRows();
        this.backgroundHeight = 114 + this.rows * 18;
        this.playerInventoryTitleY = this.backgroundHeight - 94;
        this.titleX = -1;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        // x/i: start draw left/right, y/j: start draw up/down, u: texture pull left/right, v: texture pull up/down
        // Draws the sphere pouch inventory
        context.drawTexture(TEXTURE, i-9, j, 0, 0, this.backgroundWidth+18, this.rows * 18 + 24);
        // Draws the player inventory
        context.drawTexture(TEXTURE, i, j + this.rows * 18 + 17, 10, 71, this.backgroundWidth, 96);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }
}

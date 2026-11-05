# Wither Tools (Minecraft 26.1 / Fabric)

Fabric port of [Wither Tools](https://modrinth.com/mod/wither-tools) (originally 1.21.1) to **Minecraft 26.1**.

Adds craftable blocks the Wither cannot destroy (initial explosion, blue skulls, or hurt-triggered block breaking), plus a **glass** variant.

## Contents

| ID | Description |
|----|-------------|
| `withertools:obsidian_ball` | Crafting ingredient (same recipe as 1.21.1) |
| `withertools:witherproof_block` | Solid wither-proof block (same recipe/texture as 1.21.1) |
| `withertools:witherproof_glass` | Transparent glass variant (**new** in this port) |

## Wither-proofing

1. Both blocks are in `#minecraft:wither_immune` (covers Wither skulls and the Wither’s block-breaking).
2. Blast resistance `360000` (same as the 1.21.1 mod).
3. Mixin safeguard on `WitherBoss` so our blocks are never broken by the hurt-destroy logic.
4. Explosion drop overrides so explosions never drop/destroy them as normal blocks.

## Building

Requires **Java 25**.

```bash
./gradlew build
```

The jar is written to `build/libs/withertools-1.0.0-26.1.jar`.

## Versions

- Minecraft `26.1`
- Fabric Loader `0.20.1`
- Fabric API `0.145.1+26.1`
- Loom `1.19.3`

## License

MIT (same as the original mod).

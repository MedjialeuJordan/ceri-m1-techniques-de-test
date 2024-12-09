package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider provider;

    @BeforeEach
    void setUp() throws PokedexException {
        provider = mock(IPokemonMetadataProvider.class);
        when(provider.getPokemonMetadata(0)).thenReturn(
            new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        when(provider.getPokemonMetadata(133)).thenReturn(
            new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Test
    void testGetPokemonMetadataBulbizarre() throws PokedexException {
        PokemonMetadata metadata = provider.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test
    void testGetPokemonMetadataAquali() throws PokedexException {
        PokemonMetadata metadata = provider.getPokemonMetadata(133);
        assertNotNull(metadata);
        assertEquals("Aquali", metadata.getName());
        assertEquals(186, metadata.getAttack());
        assertEquals(168, metadata.getDefense());
        assertEquals(260, metadata.getStamina());
    }

    @Test
    void testGetPokemonMetadataInvalid() {
        assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(-1));
    }
}

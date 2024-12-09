package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IPokemonFactoryTest {

    private IPokemonFactory factory;

    @BeforeEach
    void setUp() {
        factory = mock(IPokemonFactory.class);
        when(factory.createPokemon(0, 15, 15, 15, 5000))
            .thenReturn(new Pokemon(0, "Bulbizarre", 613, 64, 5000, 5, 141, 141, 105, 56.0));
        when(factory.createPokemon(133, 10, 12, 8, 3000))
            .thenReturn(new Pokemon(133, "Aquali", 2729, 202, 3000, 10, 196, 180, 268, 100.0));
    }

    @Test
    void testCreatePokemonBulbizarre() {
        Pokemon pokemon = factory.createPokemon(0, 15, 15, 15, 5000);
        assertNotNull(pokemon);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(141, pokemon.getAttack());
        assertEquals(141, pokemon.getDefense());
        assertEquals(105, pokemon.getStamina());
    }

    @Test
    void testCreatePokemonAquali() {
        Pokemon pokemon = factory.createPokemon(133, 10, 12, 8, 3000);
        assertNotNull(pokemon);
        assertEquals("Aquali", pokemon.getName());
        assertEquals(196, pokemon.getAttack());
        assertEquals(180, pokemon.getDefense());
        assertEquals(268, pokemon.getStamina());
    }

    @Test
    void testCreatePokemonInvalid() {
        when(factory.createPokemon(-1, 0, 0, 0, 0))
            .thenThrow(new IllegalArgumentException("Invalid data"));
        assertThrows(IllegalArgumentException.class, () ->
            factory.createPokemon(-1, 0, 0, 0, 0));
    }
}

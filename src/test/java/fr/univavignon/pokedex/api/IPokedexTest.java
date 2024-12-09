package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon bulbasaur;
    private Pokemon vaporeon;

    @BeforeEach
    void setUp() throws PokedexException {
        pokedex = mock(IPokedex.class);
        bulbasaur = new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 126, 126, 90, 56.0);
        vaporeon = new Pokemon(133, "Aquali", 2729, 202, 5000, 4, 186, 168, 260, 100.0);

        when(pokedex.size()).thenReturn(2);
        when(pokedex.getPokemon(0)).thenReturn(bulbasaur);
        when(pokedex.getPokemon(133)).thenReturn(vaporeon);
        when(pokedex.getPokemons()).thenReturn(List.of(bulbasaur, vaporeon));
    }

    @Test
    void testAddPokemon() throws PokedexException {
        when(pokedex.addPokemon(bulbasaur)).thenReturn(0);
        int index = pokedex.addPokemon(bulbasaur);
        assertEquals(0, index);
    }

    @Test
    void testGetPokemonBulbizarre() throws PokedexException {
        Pokemon result = pokedex.getPokemon(0);
        assertNotNull(result);
        assertEquals(bulbasaur, result);
    }

    @Test
    void testGetPokemonAquali() throws PokedexException {
        Pokemon result = pokedex.getPokemon(133);
        assertNotNull(result);
        assertEquals(vaporeon, result);
    }

    @Test
    void testGetPokemonInvalid() {
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(-1));
    }

    @Test
    void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals(bulbasaur, pokemons.get(0));
        assertEquals(vaporeon, pokemons.get(1));
    }
}

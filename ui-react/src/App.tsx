import React from 'react';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import HomePage from './pages/home/HomePage';
import LoginPage from './pages/login/LoginPage';
import './AppStyle.scss';
import FindRecipes from './pages/home/components/find-recipes/FindRecipes';
import CreateRecipe from './pages/home/components/create-recipe/CreateRecipe';

const App: React.FunctionComponent = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/'>
                    <Route path='find-recipes' element={<FindRecipes/>}/>
                    <Route path='create-recipe' element={<CreateRecipe/>}/>
                    <Route path='login' element={<LoginPage/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
};

export default App;
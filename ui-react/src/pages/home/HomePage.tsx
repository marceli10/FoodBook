import React from 'react';
import { useNavigate } from 'react-router-dom';

const HomePage: React.FunctionComponent = () => {
    const navigate = useNavigate();

    React.useEffect(() => {
        const token: string = localStorage.getItem('token');
        if (!token) {
            navigate('/login');
        }
    });

    return (
        <div>
            <h1>HOme</h1>
        </div>
    );
};

export default HomePage;
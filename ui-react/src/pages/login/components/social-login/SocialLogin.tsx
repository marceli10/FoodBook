import React from 'react';
import GoogleLogin from './google/GoogleLogin';
import './SocialLoginStyle.scss';
import {GoogleOAuthProvider} from '@react-oauth/google';

const SocialLogin: React.FunctionComponent = () => {

    return (
        <div className='social-login-container'>
            <hr/>
            <GoogleOAuthProvider clientId={import.meta.env.VITE_GOOGLE_CLIENT_ID}>
                <GoogleLogin/>
            </GoogleOAuthProvider>
        </div>
    );
};

export default SocialLogin;
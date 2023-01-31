import { missingDogList } from 'mocks/data/missing';
import { rest } from 'msw';

export const missing = [
  rest.get(`${process.env.REACT_APP_API_URL}/reports/missings`, (req, res, ctx) => {
    const code = req.url.searchParams.get('code');
    if (code === 0) {
      return res(ctx.status(200), ctx.json(missingDogList));
    }
    return res(ctx.status(200), ctx.json(missingDogList));
  }),
];
